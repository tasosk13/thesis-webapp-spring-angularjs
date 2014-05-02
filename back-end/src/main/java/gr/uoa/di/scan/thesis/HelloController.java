package gr.uoa.di.scan.thesis;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HelloController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public @ResponseBody
	String squareRoot() {
		String retValue = "{ 'welcome': 'Time is %s' }";
		return String.format(retValue, new Date().toString());
	}

	@RequestMapping(value = "/sqroot/{number}", method = RequestMethod.GET)
	public @ResponseBody
	String squareRoot(@PathVariable double number) {
		String retValue = "{ 'home': '%f' }";
		return String.format(retValue, Math.pow(number, 2.0));
	}
}
