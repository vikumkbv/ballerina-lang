/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.ballerinalang.openapi.cmd;

import org.ballerinalang.tool.BLauncherCmd;
import picocli.CommandLine;

/**
 * Main class to implement "openapi" command for ballerina.
 * This class will accept sub-commands and execute the relevant sub-command class as given to the sub-commands
 * parameter.
 *
 * Command usage will change according to the sub-command.
 */
@CommandLine.Command(name = "openapi", description = "Generate ballerina service/client using an OpenApi definition" +
    " or export an OpenApi contract for given Ballerina service.",
    subcommands = {
        OpenApiGenServiceCmd.class,
        OpenApiGenClientCmd.class,
        OpenApiGenContractCmd.class
    }
)
public class OpenApiCmd implements BLauncherCmd {
    private static final String CMD_NAME = "openapi";

    @Override
    public void execute() {
        System.out.println("testiugf");
        //Migrated the command logic to sub commands. This execute is needed if the main command needs to be executed
        //other than a sub-command.
    }

    @Override
    public String getName() {
        return CMD_NAME;
    }

    @Override
    public void printLongDesc(StringBuilder out) {
    }

    @Override
    public void printUsage(StringBuilder stringBuilder) {
    }

    @Override
    public void setParentCmdParser(CommandLine parentCmdParser) { }

}
