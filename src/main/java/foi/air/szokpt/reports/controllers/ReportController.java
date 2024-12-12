package foi.air.szokpt.reports.controllers;

import foi.air.szokpt.reports.dtos.responses.ApiResponse;
import foi.air.szokpt.reports.dtos.responses.SuccessReportData;
import foi.air.szokpt.reports.services.ReportService;
import foi.air.szokpt.reports.util.ApiResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/successful-transactions")
    public ResponseEntity<ApiResponse<SuccessReportData>> successReport(){
        SuccessReportData data = reportService.getSuccessReport();
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponseUtil.successWithData("Successful login", data)
        );
    }

}
