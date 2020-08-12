package com.parvanpajooh.bill.controller;

import captcha.CaptchaGenerator;
import captcha.CaptchaUtils;
import com.parvanpajooh.bill.exceptions.*;
import com.parvanpajooh.bill.model.*;
import com.parvanpajooh.bill.model.ResponseStatus;
import com.parvanpajooh.bill.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/v1")
public class BillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
    private static final Map<String, String> captchaUuidMap = new HashMap<>();

    @Autowired
    BillService billService;
    //    @Autowired
    Captcha captcha;

    @GetMapping("/bills/search/init")
    public ResponseEntity initSearchForm()  {
        ResponseEnvelopeDto responseEnvelopeDto = new ResponseEnvelopeDto();
        ResponseStatus responseStatus = new ResponseStatus();

        try {
            CaptchaGenerator captchaGenerator = new CaptchaGenerator();
            nl.captcha.Captcha captcha = captchaGenerator.createCaptcha(200, 50);
            int y =10/0;
            String captchaPlainText = captcha.getAnswer();
            String captchaEncode = CaptchaUtils.encodeBase64(captcha);
            String captchaId = UUID.randomUUID().toString();
            PaymentInitDto paymentInitDto = new PaymentInitDto(captchaId, captchaEncode);
            captchaUuidMap.put(captchaId, captchaPlainText);

            responseEnvelopeDto.setData((paymentInitDto));
            return ResponseEntity.ok(responseEnvelopeDto);
        }catch (Exception e){
            if (e instanceof ParvanException) {
                ParvanException pe = (ParvanException) e;
                responseStatus.setCode(pe.getErrorCode().toString());
            } else {
                // do nothing
            }
            responseStatus.setMessage(e.getMessage());
            responseStatus.setTimestamp(LocalDateTime.now().toString());
            responseEnvelopeDto.setStatus(responseStatus);
            return (ResponseEntity) ResponseEntity.notFound(responseEnvelopeDto);
//            return ResponseEntity.ok(responseEnvelopeDto);
        }
    }

    @GetMapping("/bills")
    @ResponseBody

    public ResponseEntity search(@RequestParam String captchaId, String captchaPlainValue,String chargeId) throws ParvanServiceException {
        SearchBillDto searchBillDto =new SearchBillDto();
        searchBillDto.setCaptchId(captchaId);
        searchBillDto.setCaptchaPlainValue(captchaPlainValue);
        searchBillDto.setChargeId(chargeId);
        LOGGER.debug("Entering search({})", searchBillDto);
        ResponseEnvelopeDto responseEnvelopeDto = new ResponseEnvelopeDto();
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            String captchaPlainText = captchaUuidMap.get(searchBillDto.getCaptchaId());

            if (captchaPlainText == null) {
                LOGGER.debug("chargeId not found");

                throw new ParvanRecoverableException(
                        "chargeId not found",
                        ErrorCode.INVALID_CAPTCHA_STATE);

            } else {
                LOGGER.debug("searchBillDto.getCaptchaPlainValue()={})", searchBillDto.getCaptchaPlainValue());
                LOGGER.debug("captchaPlainText={}", captchaPlainText);
                if (searchBillDto.getCaptchaPlainValue().equalsIgnoreCase(captchaPlainText)) {
                    LOGGER.debug("captcha matched");
                    Bill bill = billService.findByChargeId(searchBillDto.getChargeId());
                    responseEnvelopeDto.setData(bill);
                    return ResponseEntity.ok(responseEnvelopeDto);
                } else {
                    LOGGER.debug("captcha not matched");
                    throw new ParvanServiceException("captcha incorrect", ErrorCode.INVALID_CAPTCHA_VALUE);
                }
            }

        } catch (Exception e) {
            if (e instanceof ParvanException) {
                ParvanException pe = (ParvanException) e;
                responseStatus.setCode(pe.getErrorCode().toString());
            } else {
                // do nothing
            }
            responseStatus.setMessage(e.getMessage());
            responseStatus.setTimestamp(LocalDateTime.now().toString());
            responseEnvelopeDto.setStatus(responseStatus);
//            throw  new ParvanUnrecoverableException("Error occured while search payment",e);
            return ResponseEntity.ok(responseEnvelopeDto);
        }
    }
}