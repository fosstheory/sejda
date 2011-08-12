/*
 * Created on 28/jul/2011
 *
 * Copyright 2011 by Andrea Vacondio (andrea.vacondio@gmail.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.sejda.core.manipulation.model.parameter;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Parameter class for a simple split task. Used to perform split types which have a predefined set of pages based on the selected split type.
 * 
 * @author Andrea Vacondio
 * 
 */
public class SimpleSplitParameters extends AbstractSplitByPageParameters {

    @NotNull
    private SimpleSplitType splitType;

    public SimpleSplitParameters(SimpleSplitType splitType) {
        this.splitType = splitType;
    }

    @Override
    public Set<Integer> getPages(int upperLimit) {
        return splitType.getPages(upperLimit);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append(splitType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(splitType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleSplitParameters)) {
            return false;
        }
        SimpleSplitParameters parameter = (SimpleSplitParameters) other;
        return new EqualsBuilder().appendSuper(super.equals(other)).append(splitType, parameter.splitType).isEquals();
    }
}
