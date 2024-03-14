package  ma.zs.univ.ws.facade.admin.purchase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.purchase.PurchaseItem;
import ma.zs.univ.dao.criteria.core.purchase.PurchaseItemCriteria;
import ma.zs.univ.service.facade.admin.purchase.PurchaseItemAdminService;
import ma.zs.univ.ws.converter.purchase.PurchaseItemConverter;
import ma.zs.univ.ws.dto.purchase.PurchaseItemDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/purchaseItem/")
public class PurchaseItemRestAdmin  extends AbstractController<PurchaseItem, PurchaseItemDto, PurchaseItemCriteria, PurchaseItemAdminService, PurchaseItemConverter> {



    @Operation(summary = "upload one purchaseItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple purchaseItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all purchaseItems")
    @GetMapping("")
    public ResponseEntity<List<PurchaseItemDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  purchaseItem")
    @PostMapping("")
    public ResponseEntity<PurchaseItemDto> save(@RequestBody PurchaseItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  purchaseItem")
    @PutMapping("")
    public ResponseEntity<PurchaseItemDto> update(@RequestBody PurchaseItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of purchaseItem")
    @PostMapping("multiple")
    public ResponseEntity<List<PurchaseItemDto>> delete(@RequestBody List<PurchaseItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified purchaseItem")
    @DeleteMapping("")
    public ResponseEntity<PurchaseItemDto> delete(@RequestBody PurchaseItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified purchaseItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple purchaseItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by product id")
    @GetMapping("product/id/{id}")
    public List<PurchaseItemDto> findByProductId(@PathVariable Long id){
        return findDtos(service.findByProductId(id));
    }
    @Operation(summary = "delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @Operation(summary = "find by purchase id")
    @GetMapping("purchase/id/{id}")
    public List<PurchaseItemDto> findByPurchaseId(@PathVariable Long id){
        return findDtos(service.findByPurchaseId(id));
    }
    @Operation(summary = "delete by purchase id")
    @DeleteMapping("purchase/id/{id}")
    public int deleteByPurchaseId(@PathVariable Long id){
        return service.deleteByPurchaseId(id);
    }

    @Operation(summary = "Finds a purchaseItem and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PurchaseItemDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds purchaseItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PurchaseItemDto>> findByCriteria(@RequestBody PurchaseItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated purchaseItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PurchaseItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports purchaseItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PurchaseItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets purchaseItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PurchaseItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PurchaseItemRestAdmin (PurchaseItemAdminService service, PurchaseItemConverter converter) {
        super(service, converter);
    }




}
