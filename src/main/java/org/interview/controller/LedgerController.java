package org.interview.controller;
import org.interview.domain.LedgerModel;
import org.interview.domain.StockModel;
import org.interview.service.LedgerService;
import org.interview.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteRef;

/**
 * (Ledger)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Autowired
    private LedgerService ledgerService;

    @PostMapping("/outOrIn")
    public ResponseResult outOrIn(@RequestBody StockModel model) {

        return ledgerService.outOrIn(model);
    }

    @GetMapping("/list")
    public ResponseResult queryLedger(LedgerModel ledgerModel) {
        return ledgerService.queryLedger(ledgerModel);
    }

    @GetMapping("/count/{id}")
    public ResponseResult countGood(@PathVariable Long id) {
        return ledgerService.countGood(id);
    }
}

