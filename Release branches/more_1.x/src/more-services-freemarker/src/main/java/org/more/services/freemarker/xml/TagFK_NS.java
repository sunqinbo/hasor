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
package org.more.services.freemarker.xml;
import org.more.hypha.commons.xml.Tag_Abstract;
import org.more.hypha.context.xml.XmlDefineResource;
import org.more.services.freemarker.FreemarkerService;
/**
 * ���ڽ���freemarker�����ռ��ǩ���������࣬��Ҫ�������ֲ�ͬ�����ռ䡣
 * @version 2010-10-9
 * @author ������ (zyc@byshell.org)
 */
public abstract class TagFK_NS extends Tag_Abstract {
    private FreemarkerService service = null;
    public TagFK_NS(XmlDefineResource configuration, FreemarkerService service) {
        super(configuration);
        this.service = service;
    }
    /**��ȡRMI����*/
    protected FreemarkerService getService() {
        return this.service;
    };
}