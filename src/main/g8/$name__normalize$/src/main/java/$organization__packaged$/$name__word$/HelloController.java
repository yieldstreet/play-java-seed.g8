package $organization;format="packaged"$.$name;format="word"$;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HelloController extends Controller {
    private final ObjectMapper objectMapper;

    @Inject
    public HelloController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Result hello(Http.Request request) {
        var headers = objectMapper.valueToTree(request.getHeaders().asMap());
        return ok(headers);
    }
}
