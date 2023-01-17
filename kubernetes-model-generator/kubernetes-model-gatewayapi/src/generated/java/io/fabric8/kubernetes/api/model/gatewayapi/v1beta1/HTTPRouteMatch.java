
package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "headers",
    "method",
    "path",
    "queryParams"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class HTTPRouteMatch implements KubernetesResource
{

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeaderMatch> headers = new ArrayList<HTTPHeaderMatch>();
    @JsonProperty("method")
    private String method;
    @JsonProperty("path")
    private HTTPPathMatch path;
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPQueryParamMatch> queryParams = new ArrayList<HTTPQueryParamMatch>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPRouteMatch() {
    }

    /**
     * 
     * @param headers
     * @param path
     * @param method
     * @param queryParams
     */
    public HTTPRouteMatch(List<HTTPHeaderMatch> headers, String method, HTTPPathMatch path, List<HTTPQueryParamMatch> queryParams) {
        super();
        this.headers = headers;
        this.method = method;
        this.path = path;
        this.queryParams = queryParams;
    }

    @JsonProperty("headers")
    public List<HTTPHeaderMatch> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<HTTPHeaderMatch> headers) {
        this.headers = headers;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("path")
    public HTTPPathMatch getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(HTTPPathMatch path) {
        this.path = path;
    }

    @JsonProperty("queryParams")
    public List<HTTPQueryParamMatch> getQueryParams() {
        return queryParams;
    }

    @JsonProperty("queryParams")
    public void setQueryParams(List<HTTPQueryParamMatch> queryParams) {
        this.queryParams = queryParams;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
