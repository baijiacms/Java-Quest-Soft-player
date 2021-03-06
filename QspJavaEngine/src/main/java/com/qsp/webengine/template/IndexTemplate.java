package com.qsp.webengine.template;

import com.qsp.player.core.QspConstants;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.StringWriter;

/**
 * 游戏主窗口，iframe关联其他窗口
 * @author cxy
 */
public class IndexTemplate {
    private Template indexTemplate;
    private Template indexSobTemplate;
    private Template indexBigKuyashTemplate;

    public IndexTemplate(VelocityEngine ve) {

        indexTemplate = ve.getTemplate("baijiacms/html/core/index.vm", "utf-8");
        indexSobTemplate = ve.getTemplate("baijiacms/html/diy/sobIndex.vm", "utf-8");
        indexBigKuyashTemplate = ve.getTemplate("baijiacms/html/diy/bigKuyashIndex.vm", "utf-8");
    }

    public String getIndexHtml() {
        VelocityContext context = new VelocityContext();

//        context.put("screen_width", screen_width);
//        context.put("screen_height", screen_height);
//        context.put("user_width", user_width);
//        context.put("user_height", user_height);
//        context.put("action_width", action_width);
//        context.put("action_height", action_height);
//        context.put("root_width", root_width);
//        context.put("root_height", root_height);
        context.put("gameTitle", QspConstants.GAME_TITLE);
        context.put("gameVersion", QspConstants.GAME_VERSION);
        context.put("engineVersion", QspConstants.ENGINE_VERSION);


        StringWriter writer = new StringWriter();
        if(QspConstants.IS_SOB_GAME) {
            indexSobTemplate.merge(context, writer);
        }else
        {
            if(QspConstants.IS_BIG_KUYASH) {
                indexBigKuyashTemplate.merge(context, writer);
            }else
            {
                indexTemplate.merge(context, writer);
            }
        }
        writer.flush();
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
