/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.platform.webapps.business.scene2.web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.platform.context.ViewContext;
import org.platform.security.AuthSession;
import org.platform.security.SecurityContext;
import org.platform.security.SecurityDispatcher;
import org.platform.security.UserIdentity;
import org.platform.security.UserIdentityUtil;
import org.platform.web.WebServlet;
import org.platform.webapps.safety.AdminUser;
import org.platform.webapps.safety.BBSUser;
import com.google.inject.Inject;
/**
 * 
 * @version : 2013-5-2
 * @author ������ (zyc@byshell.org)
 */
@WebServlet("*/scene2.do")
public class Scene2_HttpServlet extends HttpServlet {
    private static final long serialVersionUID = -8203858833170622693L;
    @Inject
    private SecurityContext   securityContext  = null;
    //
    //
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewContext currentViewContext = ViewContext.currentViewContext();
        String requestURI = currentViewContext.getRequestURI();
        SecurityDispatcher dispatcher = this.securityContext.getDispatcher(requestURI);
        //
        //
        UserIdentity adminIdentity = UserIdentityUtil.getTypeIdentity(BBSUser.class);
        AuthSession[] auth = securityContext.findCurrentAuthSession(adminIdentity);
        //
        //
        String goID = req.getParameter("goID");
        dispatcher.forward(goID, currentViewContext);
    }
}