package cn.yiyang.system.config.wx.utils;

import cn.yiyang.system.config.wx.config.WxCpConfiguration;
import me.chanjar.weixin.cp.api.WxCpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/28 21:23
 * @Description:
 */
@Service
public class WxCpServiceUtils {

    @Value("${cn.agentId}")
    private Integer agentId;

    public WxCpService getWxCpService() {
        System.out.println(agentId);
        return WxCpConfiguration.getCpServices().get(agentId);
    }
}
