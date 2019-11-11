package ma.adria.ensa.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ClientRestService {
	@Value("${clientParameter}")
	private int clientParameter;
	@Value("${glogalParameter}")
	private int glogalParameter;
	@Value("${mail}")
	private String mail;

	@GetMapping("/myConfig")
	public Map<String, Object> myConfig() {
		Map<String, Object> params = new HashMap<>();
		params.put("clientParameter", clientParameter);
		params.put("glogalParameter", glogalParameter);
		params.put("mail", mail);
		params.put("threadName", Thread.currentThread().getName());
		return params;
	}
}
