package de.champonthis.ghs.server.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("backup")
public class GameBackupController {

	private final String path;
	private final String authorization;

    public GameBackupController(
			@Value("${ghs-server.backup.path:}") String path,
			@Value("${ghs-server.backup.authorization:}")String authorization
	) {
        this.path = path;
        this.authorization = authorization;
    }

    @PostMapping(value = "{filename}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void storeBackup(
			@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String authorizationHeader,
			@PathVariable("filename") String filename, @RequestBody String payload) {
		if (!StringUtils.hasText(path)) {
			throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
		}

		if (StringUtils.hasText(authorization) && !authorization.equals(authorizationHeader)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(path + (path.endsWith(File.separator) ? "" : File.separator) + filename),
                StandardCharsets.UTF_8))) {
			writer.write(payload);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
