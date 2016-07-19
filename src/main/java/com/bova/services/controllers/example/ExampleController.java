package com.bova.services.controllers.example;

import com.bova.services.controllers.AbstractController;
import com.bova.services.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Myko Bova
 */
@Controller
@RequestMapping("/example")
public class ExampleController extends AbstractController {

    /**
     * Read a file by path that contains parameter
     */
    @RequestMapping(path = "/account/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public String getAccount(@PathVariable String accountId) {
        return FileUtil.readJsonFile("repositories/example/account", accountId, "account");
    }

    /**
     * Read a file by constant path
     */
    @RequestMapping(path = "/account/types", method = RequestMethod.GET)
    @ResponseBody
    public String getOperationTypes() {
        return FileUtil.readJsonFile("repositories/example/account/types");
    }

    /**
     * Read pdf file
     */
    @RequestMapping(path = "{profileId}/reports/{reportDate}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getReportByDate(@PathVariable String profileId, @PathVariable String reportDate){

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        return new ResponseEntity<>(FileUtil.getRawFile("repositories/example/profiles/report.pdf"), headers, HttpStatus.OK);
    }

    /**
     * Read cvs file
     */
    @RequestMapping(path = "reports2", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> defaultResponse() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.TEXT_PLAIN_VALUE);
        return new ResponseEntity<>(FileUtil.getRawFile("repositories/example/profiles/report.cvs"), headers, HttpStatus.OK);
    }
}
