package io.pivotal.pa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by cdelashmutt on 3/30/17.
 */
@Controller
public class FileReadController {

	@RequestMapping("/")
	public ResponseEntity<String> main()
	throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("sample-jar-with-files-external-0.0.1-SNAPSHOT/test.txt"));
		return ResponseEntity.ok(new String(encoded, Charset.defaultCharset()));
	}

	@RequestMapping("/curdir")
	public ResponseEntity<String> curdir()
			throws IOException {
		return ResponseEntity.ok(Paths.get(".").toAbsolutePath().toString());
	}
}
