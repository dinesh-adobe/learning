/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package dinesh.learning.core.models;

import com.adobe.cq.export.json.SlingModelFilter;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Optional;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;
import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;

@Model(adaptables = {Resource.class}, defaultInjectionStrategy =  OPTIONAL)
public class HelloWorldModel {

    /********* SlingHttpServletRequest.class **************/

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL,name = JcrConstants.JCR_TITLE)
    private String pageTitle;

    @ScriptVariable
    SlingHttpServletRequest servletRequest;

    @Self
    SlingHttpServletRequest request;



    @ValueMapValue
    @Named("jcr:title")
    private String pageTitlee;

    @ScriptVariable(name = JcrConstants.JCR_TITLE)
    private String pageTitleee;

    @ScriptVariable
    private Page currentPage;

    @ScriptVariable
    Resource resource;

    /********* Resource.class ***********/

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    /******* Calling to Another OSGi service ********/

    @OSGiService
    private QueryBuilder queryBuilder;

    @OSGiService
    private SlingModelFilter slingModelFilter;

    @OSGiService
    private SlingSettingsService slingSettingsService;


   /******* Variable Declarations **********/

    private String message;

    @PostConstruct
    protected void init() {

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                .map(Page::getPath).orElse("");

        message = "Hello World!\n"
            + "Resource type is: " + resourceType + "\n"
            + "Current page is:  " + currentPagePath + "\n";

        System.out.println("Current Page " + currentPage);
        System.out.println("Page Tile " + pageTitle);
        System.out.println("Resource " + resource);


        /*******To fetch Run modes of instance by slingSettingsService service *********/
        System.out.println("RunModes " + slingSettingsService.getRunModes().contains("author"));

    }

    public String getMessage() {
        return message;
    }


}
