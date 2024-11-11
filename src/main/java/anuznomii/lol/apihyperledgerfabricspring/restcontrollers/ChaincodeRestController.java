package anuznomii.lol.apihyperledgerfabricspring.restcontrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chaincode")
@RequiredArgsConstructor
public class ChaincodeRestController {
    // inject chaincode service here
    private final ChaincodeService chaincodeService;

    @PostMapping("/{chaincodeName}/{functionName}/invoke")
    public String invokeChaincode(
            @PathVariable String chaincodeName,
            @PathVariable String functionName

    ) throws Exception {
        chaincodeService.invokeChaincode(chaincodeName,
                functionName, "null");
        return "Invoke chaincode " + functionName + " successfully!!!";
    }

    @GetMapping("/{chaincodeName}/{functionName}/query")
    public ResponseEntity<String> queryChaincode(
            @PathVariable String chaincodeName,
            @PathVariable String functionName) throws Exception {

        return ResponseEntity.ok(
                chaincodeService.queryChaincode(chaincodeName,
                        functionName, ""));
    }

}
