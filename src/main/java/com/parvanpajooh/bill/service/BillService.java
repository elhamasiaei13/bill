package com.parvanpajooh.bill.service;

import captcha.CaptchaGenerator;
import captcha.CaptchaUtils;
import com.parvanpajooh.bill.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

@Service
public class BillService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class);
    private static final Map<String, Bill> billsMap = new HashMap<>();
    private static final Map<String, String> captchaUuidMap = new HashMap<>();

    static {

        Bill aBill;
        List<BillItem> billItems;
        BillItem aBi;
        BigDecimal amount;

        /* *********************************************** */
        billItems = new ArrayList<>();
        aBi = new BillItem();
        aBi.setDescription("First Bill Item");
        amount = new BigDecimal("150000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBi = new BillItem();
        aBi.setDescription("Second Bill Item");
        amount = new BigDecimal("28000000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBi = new BillItem();
        aBi.setDescription("3th Bill Item");
        amount = new BigDecimal("4900000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBill = new Bill("1500-700-800", "elham", billItems);
        billsMap.put(aBill.getChargeId(), aBill);

        /* *********************************************** */
        billItems = new ArrayList<>();
        aBi = new BillItem();
        aBi.setDescription("خرید لوازم شبکه");
        amount = new BigDecimal("8750000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBi = new BillItem();
        aBi.setDescription("نصب تجهیزات شبکه");
        amount = new BigDecimal("1250000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBill = new Bill("900-700-800", "1500", billItems);
        billsMap.put(aBill.getChargeId(), aBill);

        /* *********************************************** */
        billItems = new ArrayList<>();
        aBi = new BillItem();
        aBi.setDescription("کامپیوتر شخصی");
        amount = new BigDecimal("890000000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBi = new BillItem();
        aBi.setDescription("نصب سیستم عامل");
        amount = new BigDecimal("150000");
        aBi.setAmount(amount);
        billItems.add(aBi);

        aBill = new Bill("777-888-999", "1500", billItems);
        billsMap.put(aBill.getChargeId(), aBill);
    }

    public Bill findByChargeId(String chargeId) {
        LOGGER.debug("Entering getByChargeId(chargeId:{})", chargeId);

        if (chargeId != null) {
            Bill foundBill = billsMap.get(chargeId);
            LOGGER.info("found bill[{}]", foundBill);
            return foundBill;
        }
        {
            LOGGER.info("chargeId is null");
            return null;
        }
    }

}
