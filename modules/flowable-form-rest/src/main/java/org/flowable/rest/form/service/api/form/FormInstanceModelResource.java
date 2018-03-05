/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.flowable.rest.form.service.api.form;

import javax.servlet.http.HttpServletRequest;

import org.flowable.engine.common.api.FlowableIllegalArgumentException;
import org.flowable.engine.common.api.FlowableObjectNotFoundException;
import org.flowable.form.api.FormInstanceInfo;
import org.flowable.form.api.FormService;
import org.flowable.rest.form.FormRestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * @author Yvo Swillens
 */
@RestController
@Api(tags = { "Form Instance Models" }, description = "Manage Form Instance Models", authorizations = { @Authorization(value = "basicAuth") })
public class FormInstanceModelResource {

    @Autowired
    protected FormService formService;

    @Autowired
    protected FormRestResponseFactory formRestResponseFactory;

    @ApiOperation(value = "Get a form instance model", tags = { "Form Instance Models" }, nickname = "getFormInstanceModel")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indicates the form instance was found and the model is returned."),
            @ApiResponse(code = 404, message = "Indicates the form instance was not found.")
    })
    @PostMapping(value = "/form/form-instance-model", produces = "application/json")
    public FormInstanceModelResponse getFormInstanceModel(@ApiParam(name = "formInstanceModelRequest") @RequestBody FormRequest formRequest, HttpServletRequest request) {

        FormInstanceInfo formInstanceModel;

        if (formRequest.getFormInstanceId() != null) {
            formInstanceModel = formService.getFormInstanceModelById(
                    formRequest.getFormInstanceId(),
                    null);
        } else if (formRequest.getParentDeploymentId() != null) {
            formInstanceModel = formService.getFormInstanceModelByKeyAndParentDeploymentId(
                    formRequest.getParentDeploymentId(),
                    formRequest.getFormDefinitionKey(),
                    formRequest.getTaskId(),
                    formRequest.getProcessInstanceId(),
                    formRequest.getVariables(),
                    formRequest.getTenantId());
            
        } else if (formRequest.getFormDefinitionKey() != null) {
            formInstanceModel = formService.getFormInstanceModelByKey(
                    formRequest.getFormDefinitionKey(),
                    formRequest.getTaskId(),
                    formRequest.getProcessInstanceId(),
                    formRequest.getVariables(),
                    formRequest.getTenantId());
            
        } else if (formRequest.getFormDefinitionId() != null) {
            formInstanceModel = formService.getFormInstanceModelById(
                    formRequest.getFormDefinitionId(),
                    formRequest.getTaskId(),
                    formRequest.getProcessInstanceId(),
                    formRequest.getVariables(),
                    formRequest.getTenantId());
            
        } else {
            throw new FlowableIllegalArgumentException("Either parent deployment key, form definition key or form definition id must be provided in the request");
        }

        if (formInstanceModel == null) {
            throw new FlowableObjectNotFoundException("Could not find a form instance");
        }

        return formRestResponseFactory.createFormInstanceModelResponse(formInstanceModel);
    }
}
