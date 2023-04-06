package dinesh.learning.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.Query;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.eclipse.jetty.util.ajax.JSON;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/search")
public class SearchProcess extends SlingSafeMethodsServlet {

    @Reference
    private transient QueryBuilder queryBuilder;

    @Override
    protected void doGet( SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver resolver = request.getResourceResolver();
        Session session = resolver.adaptTo(Session.class);

        Map<String, String> map = new HashMap<String, String>();
        map.put("path","/content");
        map.put("1_property", "jcr:title");
        map.put("1_property.1_value", request.getParameter("keyword"));
        map.put("1_property.operation", "like");
        map.put("p.guessTotal", "true");
        map.put("orderby", "path");

        Query query = queryBuilder.createQuery(PredicateGroup.create(map), session);
        SearchResult searchResult = query.getResult();

        List<String> page  = new ArrayList<>();

        searchResult.getHits().stream().forEach(hit -> {
            try {
                page.add(hit.getPath());
            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        });


        response.setContentType("application/json");
        response.getWriter().write("Saerch Results = " +page);
    }
}
