
package io.fabric8.openshift.api.model.machine.v1beta1;

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
    "preDrain",
    "preTerminate"
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
public class LifecycleHooks implements KubernetesResource
{

    @JsonProperty("preDrain")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LifecycleHook> preDrain = new ArrayList<LifecycleHook>();
    @JsonProperty("preTerminate")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LifecycleHook> preTerminate = new ArrayList<LifecycleHook>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LifecycleHooks() {
    }

    /**
     * 
     * @param preDrain
     * @param preTerminate
     */
    public LifecycleHooks(List<LifecycleHook> preDrain, List<LifecycleHook> preTerminate) {
        super();
        this.preDrain = preDrain;
        this.preTerminate = preTerminate;
    }

    @JsonProperty("preDrain")
    public List<LifecycleHook> getPreDrain() {
        return preDrain;
    }

    @JsonProperty("preDrain")
    public void setPreDrain(List<LifecycleHook> preDrain) {
        this.preDrain = preDrain;
    }

    @JsonProperty("preTerminate")
    public List<LifecycleHook> getPreTerminate() {
        return preTerminate;
    }

    @JsonProperty("preTerminate")
    public void setPreTerminate(List<LifecycleHook> preTerminate) {
        this.preTerminate = preTerminate;
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
