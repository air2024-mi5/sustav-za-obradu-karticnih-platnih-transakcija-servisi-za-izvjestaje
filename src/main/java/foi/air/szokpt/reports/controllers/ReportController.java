package foi.air.szokpt.reports.controllers;

import foi.air.szokpt.reports.dtos.responses.ApiResponse;
import foi.air.szokpt.reports.dtos.responses.CardBrandsReportData;
import foi.air.szokpt.reports.dtos.responses.SuccessReportData;
import foi.air.szokpt.reports.services.ReportService;
import foi.air.szokpt.reports.util.ApiResponseUtil;
import foi.air.szokpt.reports.util.Authorizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;
    private final Authorizer authorizer;

    @Autowired
    public ReportController(ReportService reportService, Authorizer authorizer){
        this.reportService = reportService;
        this.authorizer = authorizer;
    }

    @GetMapping("/successful-transactions")
    public ResponseEntity<ApiResponse<SuccessReportData>> successReport(
            @RequestHeader("Authorization") String authorizationHeader
    ){
        authorizer.verifyToken(authorizationHeader);
        SuccessReportData data = reportService.getSuccessReport(authorizationHeader);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponseUtil.successWithData("Successful login", data)
        );
    }

    @GetMapping("/card-brands")
    public ResponseEntity<ApiResponse<CardBrandsReportData>> cardBrandReport(
            @RequestHeader("Authorization") String authorizationHeader
    ){
        authorizer.verifyToken(authorizationHeader);
        CardBrandsReportData data = reportService.getCardBrandsReport(authorizationHeader);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponseUtil.successWithData("Successful login", data)
        );
    }
}
