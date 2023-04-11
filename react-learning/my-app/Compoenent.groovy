Compoenent
*   Slightly 
    *   data-sly-use
    *   data-sly-test
    *   data-sly-template
    *   properties
    *   pageProperties
    *   inheritedPageProperties

*   ClientLibs
    *   Categories Name
    *   allowProxy
    *   dependecies
    *   embed Dependecies

*   Dialog
    *   Overriding - link
    *   Overlaying - copy
    *   Sling Merger API
        *   sling:hideResource
        *   sling:orderBefore

*   SlingModel
    *   Types
        *   Adaptorables    
            *   Resource.class
            *   SlingServeltsRequest.class
        *   Multifield
            *   Resource.class
    *   Annonations
        *   @Inject
        *   @ValueMyMap
        *   @PostConstruct
        *   @ScriptVariable
        *   @OSGiService

Template
*   Editable Types
    *   Template <-> Page
    *   TemplateType <-> base page Component
*   Config Dialog   
    *   Initial ->  This is main Author can delete Compoenent if they not required.
    *   Structure -> This config by Developer and will changed/delete by author.
    *   Component Lock/unlock - >  Developer can select which component group should use or specific component.
    *   Policies - > we can edit polices -like page properties such as intial js or css should be loaded.
*   Configuration part 

Servelts
*   Registeration Types
    *   ResourceType - it provide ACL Security and it can access when resource is avaliable
    *   Path Type  - it access when url is hit in browser.
*   Types
    *   SlingSafeMethods - doGet Methods
    *   SlingALlMethods - all doGet/doPost/doput
*   Annonations
    *   @Component
    *   @slingResourceType
    *   @slingPathType
*   Script Resolver
    *   ScriptResolver osgi service -> To update Execution path.


OSGi Service
*   Lifecycle
    *   Installed
    *   Resolved
        *   Start
        *   Active
        *   Stop
    *   Uninstalled

*   Structure
    *   Annonations
        *   @Component
        *   @Desginate
        *   @Reference 
    *   OCD interface
        *   @ObjectClassDefinition
            *   @AttributeDefinition
                *   String
                *   Boolean
                *   String[]
                *   Options
*   Types
    *   Normal Service
        *   @Activate @Modified
            *   protected void activate(Config cfg) 
    *   Factory Service - When we have pass multiple configuration need from admin/bussiness order
        *   bind fucntion
        *   unbind fucntion


Scheduler 
*   @Compoent(service = runnable.class) 
    *   implement Runnable interface
        *   public void run() 
        *   @activate
        *   @Deactive
        *   @Modified
    *   ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
    *   Scheduler.schedule(this, scheduleOptions);

* Query Builder OSGi Service
    *      

Workflow
* Types
    *   Existing Workflow
        *   DamUpdateProcess
        *   Create Version
    *   Custom Workflow
        *   Process
            *   WorkflowProcess
                *   public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap processArguments)
        *   Step/Dialog

Dispatcher
*  dispatcher.any
    *   Rewrite Rule
        *   Redirect request to some other url
        *   Redirect Condition.  
        *   Redirect Expression
            *   RewriteCond %{REQUEST_URI} !^/UK/(.*)\.html
                RewriteRule "^/UK/(.*)" "/en-UK/$1" [PT,NC]

            *   RewriteCond %{HTTP:X-Forwarded-Proto} !https

            *   RewriteRule ^/content/mysite/(.*).html$ $1.html [R,L]	
    *   Cache 
        *   By rule set 
        *   By cloudManager config
        *   By Replicatant Agent
    *   Filter 
        *   Rule set for allow and disallow configuation.
    *   Header
        *   Set different header
    *   Render
        * Publisher details configuration 

Run Modes in AEM
*   By OsgiService
    *   SlingSettingsService 
    *   slingSettingsService.getRunmode().contains(“author”);
*   Configuaation in AEM
    *   Config.dev
    *   Config.author.dev
    *   Config.publish.dev 

Cloud Manager Setup
*   Pipeline setup
        *   Configurtion
*   Enviroment Setup
*   Repository

Integrated with SPA (React js)
*   ui.frontend
    *   src folder
        *   webpack
        *   Js and css
        *   JavaScript Knowledge

Rollout 
*   Standard Rollout
*   Custom Rollout

Etc.mapping
*    



BlogList Template

Servelt call and Fetch the blogs from specific folder and make list of according their published date
and render from bloglistComponent. 

All Blogs into one folder

Blog Template
    *   Published
    *   Type
    *   Blog Name


Integraion with third parties api.
* Integrated with SaleforceCommerce.
* Product Listing Pages
    --> Improve User Behaviour 
* Product Detail Pages
    --> Product Lifecycle
    --> Product variants
    --> Product Specification and vary with different.
* By Servelts call and fetch data from saleforceapi and DigitalRiver and PIM and serialize into pojo class. once done we will
    render from into template level call and project is SPA so same data will use by react js for client side renderation.
    --> SessionId 
    --> Client Id
    --> Guest Id




Migration from on-permise 6.4 to AemAsCloud
* Code analayis
* Planing/ estimation
* Code Refractor 
    --> OSGi Annonations.
    --> ACS-Commons compartibility.
    --> Dispatcher files restructure.
    --> Another third parties Integration.
    --> CloudManager compartibility
        --> Repository Morderizer
        --> Pipeline Setup
        --> Integraion of cloud git to Client side git
        --> Security Checklist
    --> Prod Domain Switches


