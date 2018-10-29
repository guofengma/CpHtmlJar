package cn.yiyang.book.controller;

import cn.yiyang.system.config.wx.config.WxCpConfiguration;
import cn.yiyang.system.config.wx.config.WxCpProperties;
import com.google.common.collect.Lists;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import me.chanjar.weixin.cp.bean.article.NewArticle;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("")
public class WxPortalController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

//  @GetMapping(produces = "text/plain;charset=utf-8")
//  public String authGet(@PathVariable Integer agentId,
//                        @RequestParam(name = "msg_signature", required = false) String signature,
//                        @RequestParam(name = "timestamp", required = false) String timestamp,
//                        @RequestParam(name = "nonce", required = false) String nonce,
//                        @RequestParam(name = "echostr", required = false) String echostr) {
//    this.logger.info("\n接收到来自微信服务器的认证消息：signature = [{}], timestamp = [{}], nonce = [{}], echostr = [{}]",
//    signature, timestamp, nonce, echostr);
//    if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
//      throw new IllegalArgumentException("请求参数非法，请核实!");
//    }
//
//    final WxCpService wxCpService = WxCpConfiguration.getCpServices().get(agentId);
//    if (wxCpService == null) {
//      throw new IllegalArgumentException(String.format("未找到对应agentId=[%d]的配置，请核实！", agentId));
//    }
//
//    if (wxCpService.checkSignature(signature, timestamp, nonce, echostr)) {
//      return new WxCpCryptUtil(wxCpService.getWxCpConfigStorage()).decrypt(echostr);
//    }
//
//    return "非法请求";
//  }
//
//  @PostMapping(produces = "application/xml; charset=UTF-8")
//  public String post(@PathVariable Integer agentId,
//                     @RequestBody String requestBody,
//                     @RequestParam("msg_signature") String signature,
//                     @RequestParam("timestamp") String timestamp,
//                     @RequestParam("nonce") String nonce) {
//    this.logger.info("\n接收微信请求：[signature=[{}], timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
//        signature, timestamp, nonce, requestBody);
//
//    final WxCpService wxCpService = WxCpConfiguration.getCpServices().get(agentId);
//    WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(requestBody, wxCpService.getWxCpConfigStorage(),
//        timestamp, nonce, signature);
//    this.logger.debug("\n消息解密后内容为：\n{} ", JsonUtils.toJson(inMessage));
//    WxCpXmlOutMessage outMessage = this.route(agentId, inMessage);
//    if (outMessage == null) {
//      return "";
//    }
//
//    String out = outMessage.toEncryptedXml(wxCpService.getWxCpConfigStorage());
//    this.logger.debug("\n组装回复信息：{}", out);
//    return out;
//  }
//
//  private WxCpXmlOutMessage route(Integer agentId, WxCpXmlMessage message) {
//    try {
//      return WxCpConfiguration.getRouters().get(agentId).route(message);
//    } catch (Exception e) {
//      this.logger.error(e.getMessage(), e);
//    }
//
//    return null;
//  }


  @GetMapping("/test")
  public void test() throws WxErrorException {
      NewArticle article1 = new NewArticle();
      article1.setUrl("http://www.baidu.com");
      article1.setPicUrl("http://img.zcool.cn/community/0125fd5770dfa50000018c1b486f15.jpg@1280w_1l_2o_100sh.jpg");
      article1.setDescription("发货平台内容测试");
      article1.setTitle("张宏亮发送测试");
//      WxCpMessage message = WxCpMessage.NEWS().agentId(1000016).toUser("wangxiaoyu").addArticle(article1).build();
      WxCpMessage message = WxCpMessage.TEXTCARD()
              .agentId(1000016)
              .toUser("kangjintao")
              .title("领奖通知")
              .description("<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>")
              .url("https://work.weixin.qq.com/api/doc#10167")
              .build();

      WxCpConfiguration.getCpServices().get(1000016).messageSend(message);

  }

}
