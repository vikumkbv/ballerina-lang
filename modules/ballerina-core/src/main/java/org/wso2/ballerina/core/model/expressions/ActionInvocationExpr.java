/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerina.core.model.expressions;

import org.wso2.ballerina.core.model.Action;
import org.wso2.ballerina.core.model.ExecutableMultiReturnExpr;
import org.wso2.ballerina.core.model.NodeExecutor;
import org.wso2.ballerina.core.model.NodeVisitor;
import org.wso2.ballerina.core.model.SymbolName;
import org.wso2.ballerina.core.model.values.BValue;

/**
 * {@code ActionInvocationExpr} represents action invocation expression
 *
 * @since 1.0.0
 */
public class ActionInvocationExpr extends AbstractExpression implements ExecutableMultiReturnExpr {

    private SymbolName actionName;
    private Expression[] exprs;
    private Action action;

    public ActionInvocationExpr(SymbolName actionName, Expression[] exprs) {
        this.actionName = actionName;
        this.exprs = exprs;
    }

    public SymbolName getActionName() {
        return actionName;
    }

    public void setActionName(SymbolName actionName) {
        this.actionName = actionName;
    }

    public Expression[] getExprs() {
        return exprs;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public BValue[] executeMultiReturn(NodeExecutor executor) {
        return executor.visit(this);
    }

    @Override
    public BValue execute(NodeExecutor executor) {
        return executor.visit(this)[0];
    }
}
