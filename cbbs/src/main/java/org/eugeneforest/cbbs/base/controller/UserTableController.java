package org.eugeneforest.cbbs.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.eugeneforest.cbbs.base.entity.UserTable;
import org.eugeneforest.cbbs.base.service.UserTableService;
import org.eugeneforest.toolbox.api.Query;
import org.eugeneforest.toolbox.api.R;
import org.eugeneforest.toolbox.common.Func;
import org.eugeneforest.toolbox.mp.tools.CustomizedCondition;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Eugene-Forest
 * @since 2021-10-20 05:13:17
 */
@RestController
@RequestMapping("/base/userTable")
public class UserTableController {

    @Resource
    private UserTableService userTableService;


    /**
     * 新增 
     */
    @PostMapping("/save")
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "新增", notes = "传入userTable")
    public R save(@Valid @RequestBody UserTable userTable) {
        return R.status(userTableService.save(userTable));
    }

    /**
     * 删除 
     */
    @PostMapping("/remove")
    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(userTableService.removeByIds(Func.toLongList(ids)));
    }

    /**
     * 修改 
     */
    @PostMapping("/update")
    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "修改", notes = "传入userTable")
    public R update(@Valid @RequestBody UserTable userTable) {
        return R.status(userTableService.updateById(userTable));
    }

    /**
     * 新增或修改 
     */
    @PostMapping("/submit")
    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "新增或修改", notes = "传入userTable")
    public R submit(@Valid @RequestBody UserTable userTable) {
        return R.status(userTableService.saveOrUpdate(userTable));
    }

    /**
     * 自定义分页 
     */
    @GetMapping("/page")
    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "分页", notes = "传入userTable")
    public R<IPage<UserTable>> page(UserTable userTable, Query query) {
        IPage<UserTable> pages = userTableService.page(CustomizedCondition.getPage(query),
                CustomizedCondition.getQueryWrapper(userTable).orderByDesc("update_time"));
        return R.data(pages);
    }






}
