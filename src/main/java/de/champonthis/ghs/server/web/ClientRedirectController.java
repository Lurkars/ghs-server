package de.champonthis.ghs.server.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ClientRedirectController {

	private final ResourceLoader resourceLoader;

    public ClientRedirectController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(value = "/", headers = { "Connection!=upgrade", "Connection!=Upgrade",
			"Connection!=keep-alive, upgrade", "Connection!=keep-alive, Upgrade" })
	public RedirectView redirectWithUsingRedirectView() {
		Resource resource = resourceLoader.getResource(
				"file:" + new File(System.getProperty("user.home"), ".ghs" + File.separator + "gloomhavensecretariat")
						.getAbsolutePath() + File.separator + "index.html");

		if (resource.exists()) {
			return new RedirectView("index.html");
		}

		return new RedirectView("noclient.html");
	}
}
