package captcha;

import com.parvanpajooh.bill.exceptions.ErrorCode;
import com.parvanpajooh.bill.exceptions.ParvanUnrecoverableException;
import com.parvanpajooh.bill.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.backgrounds.TransparentBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.producer.TextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;
import nl.captcha.text.renderer.WordRenderer;

public class CaptchaGenerator implements InitializingBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class);

	private BackgroundProducer backgroundProducer;
	private TextProducer textProducer;
	private WordRenderer wordRenderer;
	private NoiseProducer noiseProducer;

	public Captcha createCaptcha(int width, int height)  {

		LOGGER.debug("input Create captcha");
		try {
			return new Captcha.Builder(width, height).addBackground().addText().addNoise().build();
		}catch (Exception e){
			LOGGER.debug("Error occurred while Create captcha");
			throw(e);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.backgroundProducer == null) {
			this.backgroundProducer = new TransparentBackgroundProducer();
		}
		if (this.textProducer == null) {
			this.textProducer = new DefaultTextProducer();
		}
		if (this.wordRenderer == null) {
			this.wordRenderer = new DefaultWordRenderer();
		}
		if (this.noiseProducer == null) {
			this.noiseProducer = new CurvedLineNoiseProducer();
		}
	}
}
