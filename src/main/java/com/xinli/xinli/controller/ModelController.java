package com.xinli.xinli.controller;

import com.xinli.xinli.bean.TbCatalogV1Entity;
import com.xinli.xinli.bean.TbCatalogV2Entity;
import com.xinli.xinli.bean.TbModelEntity;
import com.xinli.xinli.bean.other.TbAllCatalog;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api(tags = "模型操作Api")
@RestController
public class ModelController {

    @Autowired
    ModelService modelService;

    @ApiOperation("创建一级分类")
    @PostMapping("/api/model/createCatalogV1")
    public CommonResponse<TbCatalogV1Entity> createCatalogV1(@RequestBody TbCatalogV1Entity tbCatalogV1Entity){
        try {
            tbCatalogV1Entity = modelService.addCatalogV1(tbCatalogV1Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV1Entity>(500,"添加失败",tbCatalogV1Entity);
        }
        return new CommonResponse<TbCatalogV1Entity>(200,"添加成功",tbCatalogV1Entity);
    }

    @ApiOperation("修改一级分类,需要传入已经存在的 id")
    @PostMapping("/api/model/updateCatalogV1")
    public CommonResponse<TbCatalogV1Entity> updateCatalogV1(@RequestBody TbCatalogV1Entity tbCatalogV1Entity){
        try {
            tbCatalogV1Entity = modelService.addCatalogV1(tbCatalogV1Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV1Entity>(500,"修改失败",tbCatalogV1Entity);
        }
        return new CommonResponse<TbCatalogV1Entity>(200,"修改成功",tbCatalogV1Entity);
    }

    @ApiOperation("删除一级分类,需要传入已经存在的 id")
    @PostMapping("/api/model/deleteCatalogV1")
    public CommonResponse<TbCatalogV1Entity> deleteCatalogV1(@RequestBody TbCatalogV1Entity tbCatalogV1Entity){
        try {
            modelService.deleteCatalogV1(tbCatalogV1Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV1Entity>(500,"删除失败",tbCatalogV1Entity);
        }
        return new CommonResponse<TbCatalogV1Entity>(200,"删除成功",tbCatalogV1Entity);
    }

    @ApiOperation("创建二级分类")
    @PostMapping("/api/model/createCatalogV2")
    public CommonResponse<TbCatalogV2Entity> createCatalogV2(@RequestBody TbCatalogV2Entity tbCatalogV2Entity){
        try {
            tbCatalogV2Entity = modelService.addCatalogV2(tbCatalogV2Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV2Entity>(500,"添加失败",tbCatalogV2Entity);
        }
        return new CommonResponse<TbCatalogV2Entity>(200,"添加成功",tbCatalogV2Entity);
    }

    @ApiOperation("修改二级分类,需要传已经存在的id")
    @PostMapping("/api/model/updateCatalogV2")
    public CommonResponse<TbCatalogV2Entity> updateCatalogV2(@RequestBody TbCatalogV2Entity tbCatalogV2Entity){
        try {
            tbCatalogV2Entity = modelService.addCatalogV2(tbCatalogV2Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV2Entity>(500,"修改失败",tbCatalogV2Entity);
        }
        return new CommonResponse<TbCatalogV2Entity>(200,"修改成功",tbCatalogV2Entity);
    }

    @ApiOperation("删除二级分类,需要传已经存在的id")
    @PostMapping("/api/model/deleteCatalogV2")
    public CommonResponse<TbCatalogV2Entity> deleteCatalogV2(@RequestBody TbCatalogV2Entity tbCatalogV2Entity){
        try {
            modelService.deleteCatalogV2(tbCatalogV2Entity);
        }catch (Exception e){
            return new CommonResponse<TbCatalogV2Entity>(500,"删除失败",tbCatalogV2Entity);
        }
        return new CommonResponse<TbCatalogV2Entity>(200,"删除成功",tbCatalogV2Entity);
    }

    @ApiOperation("添加模型")
    @PostMapping("/api/model/addModel")
    public CommonResponse<TbModelEntity> createModel(@RequestBody TbModelEntity tbModelEntity){
        try {
            tbModelEntity = modelService.addModel(tbModelEntity);
        }catch (Exception e){
            return new CommonResponse<TbModelEntity>(500,"添加失败",tbModelEntity);
        }
        return new CommonResponse<TbModelEntity>(200,"添加成功",tbModelEntity);
    }

    @ApiOperation("修改模型,需要传已经存在的id")
    @PostMapping("/api/model/updateModel")
    public CommonResponse<TbModelEntity> updateModel(@RequestBody TbModelEntity tbModelEntity){
        try {
            tbModelEntity = modelService.addModel(tbModelEntity);
        }catch (Exception e){
            return new CommonResponse<TbModelEntity>(500,"修改失败",tbModelEntity);
        }
        return new CommonResponse<TbModelEntity>(200,"修改成功",tbModelEntity);
    }

    @ApiOperation("删除模型,需要传已经存在的id")
    @PostMapping("/api/model/deleteModel")
    public CommonResponse<TbModelEntity> deleteModel(@RequestBody TbModelEntity tbModelEntity){
        try {
            modelService.deleteModel(tbModelEntity);
        }catch (Exception e){
            return new CommonResponse<TbModelEntity>(500,"删除失败",tbModelEntity);
        }
        return new CommonResponse<TbModelEntity>(200,"删除成功",tbModelEntity);
    }

    @ApiOperation("获取所有的一级分类")
    @GetMapping("/api/model/getAllCatalogV1")
    public CommonResponse<List<TbCatalogV1Entity>> getAllCatalogV1(){
        try {
            List<TbCatalogV1Entity> tbCatalogV1EntityList = modelService.getAllCatalogV1();
            return new CommonResponse<List<TbCatalogV1Entity>>(200,"获取成功",tbCatalogV1EntityList);
        }catch (Exception e){
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

    @ApiOperation("根据一级分类id获取的二级分类")
    @GetMapping("/api/model/getAllV2ByV1Id")
    public CommonResponse<List<TbCatalogV2Entity>> getAllV2ByV1(Integer v1Id){
        try {
            List<TbCatalogV2Entity> tbCatalogV1EntityList = modelService.getAllV2ByV1(v1Id);
            return new CommonResponse<List<TbCatalogV2Entity>>(200,"获取成功",tbCatalogV1EntityList);
        }catch (Exception e){
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

    @ApiOperation("根据二级分类id获取模型")
    @GetMapping("/api/model/getModelByV2")
    public CommonResponse<List<TbModelEntity>> getModelByV2(Integer v2Id){
        try {
            List<TbModelEntity> tbModelEntityList = modelService.getModel(v2Id);
            return new CommonResponse<List<TbModelEntity>>(200,"获取成功",tbModelEntityList);
        }catch (Exception e){
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

    @ApiOperation("获取所有的分类及子分类-0-----------级联")
    @GetMapping("/api/model/getAllCatalog")
    public CommonResponse<List<TbAllCatalog>> getAllCatalog(){
        List<TbAllCatalog> cataLogList = modelService.getAllCatalog();
        try {
            return new CommonResponse<>(200,"请求成功",cataLogList);
        }catch (Exception e){
            return new CommonResponse<>(500,"请求失败",cataLogList);
        }

    }

    @ApiOperation("根据 id 获取模型")
    @GetMapping("/api/model/getOneModel")
    public CommonResponse<TbModelEntity> getOneModel(Integer modelId){
        TbModelEntity tbModelEntity = modelService.getOneModel(modelId);
        try {
            return new CommonResponse<>(200,"请求成功",tbModelEntity);
        }catch (Exception e){
            return new CommonResponse<>(500,"请求失败",tbModelEntity);
        }

    }
}








