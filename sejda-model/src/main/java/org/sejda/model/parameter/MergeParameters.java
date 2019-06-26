/*
 * Created on 11/ago/2011
 * Copyright 2011 by Andrea Vacondio (andrea.vacondio@gmail.com).
 * 
 * This file is part of the Sejda source code
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sejda.model.parameter;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sejda.model.input.MergeInput;
import org.sejda.model.outline.CatalogPageLabelsPolicy;
import org.sejda.model.outline.OutlinePolicy;
import org.sejda.model.pdf.form.AcroFormPolicy;
import org.sejda.model.rotation.Rotation;
import org.sejda.model.toc.ToCPolicy;
import org.sejda.model.validation.constraint.SingleOutputAllowedExtensions;

/**
 * Parameter class for a merge task containing a collection of input to be merged.
 * 
 * @author Andrea Vacondio
 * 
 */
@SingleOutputAllowedExtensions
public class MergeParameters extends BaseMergeParameters<MergeInput> {

    private boolean blankPageIfOdd = false;
    @NotNull
    private OutlinePolicy outlinePolicy = OutlinePolicy.RETAIN;
    @NotNull
    private AcroFormPolicy acroFormPolicy = AcroFormPolicy.MERGE_RENAMING_EXISTING_FIELDS;
    @NotNull
    private CatalogPageLabelsPolicy catalogPageLabelsPolicy = CatalogPageLabelsPolicy.DISCARD;
    @NotNull
    private ToCPolicy tocPolicy = ToCPolicy.NONE;
    private boolean filenameFooter = false;
    /* Makes all pages same width as the first page */
    private boolean normalizePageSizes = false;
    private boolean firstInputCoverTitle = false;

    @Valid
    private List<Rotation> rotations = new ArrayList<>();

    public boolean isBlankPageIfOdd() {
        return blankPageIfOdd;
    }

    /**
     * Setting this true tells the task to add a blank page after each merged document if the number of pages is odd. It can be useful to print the document double-sided.
     * 
     * @param blankPageIfOdd
     */
    public void setBlankPageIfOdd(boolean blankPageIfOdd) {
        this.blankPageIfOdd = blankPageIfOdd;
    }

    public AcroFormPolicy getAcroFormPolicy() {
        return this.acroFormPolicy;
    }

    /**
     * The policy that the merge task should use when handling interactive forms (AcroForm)
     * 
     * @param acroFormPolicy
     */
    public void setAcroFormPolicy(AcroFormPolicy acroFormPolicy) {
        this.acroFormPolicy = acroFormPolicy;
    }

    public OutlinePolicy getOutlinePolicy() {
        return outlinePolicy;
    }

    /**
     * The policy that the merge task should use when handling the outline tree (bookmarks)
     * 
     * @param outlinePolicy
     */
    public void setOutlinePolicy(OutlinePolicy outlinePolicy) {
        this.outlinePolicy = outlinePolicy;
    }

    public ToCPolicy getTableOfContentsPolicy() {
        return ofNullable(tocPolicy).orElse(ToCPolicy.NONE);
    }

    public void setTableOfContentsPolicy(ToCPolicy tocPolicy) {
        this.tocPolicy = tocPolicy;
    }

    public boolean isFilenameFooter() {
        return filenameFooter;
    }

    public void setFilenameFooter(boolean filenameFooter) {
        this.filenameFooter = filenameFooter;
    }

    public boolean isNormalizePageSizes() {
        return normalizePageSizes;
    }

    public void setNormalizePageSizes(boolean normalizePageSizes) {
        this.normalizePageSizes = normalizePageSizes;
    }

    public CatalogPageLabelsPolicy getCatalogPageLabelsPolicy() {
        return catalogPageLabelsPolicy;
    }

    public void setCatalogPageLabelsPolicy(CatalogPageLabelsPolicy catalogPageLabelsPolicy) {
        this.catalogPageLabelsPolicy = catalogPageLabelsPolicy;
    }

    public boolean isFirstInputCoverTitle() {
        return firstInputCoverTitle;
    }

    public void setFirstInputCoverTitle(boolean firstInputCoverTitle) {
        this.firstInputCoverTitle = firstInputCoverTitle;
    }

    public List<Rotation> getRotations() {
        return rotations;
    }

    public void setRotations(List<Rotation> rotations) {
        this.rotations = rotations;
    }

    public Rotation getRotation(int index) {
        if(index >= rotations.size()) {
            return Rotation.DEGREES_0;
        }

        return rotations.get(index);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(acroFormPolicy)
                .append(blankPageIfOdd).append(outlinePolicy).append(tocPolicy).append(filenameFooter)
                .append(normalizePageSizes).append(catalogPageLabelsPolicy).append(firstInputCoverTitle)
                .append(rotations)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeParameters)) {
            return false;
        }
        MergeParameters params = (MergeParameters) other;
        return new EqualsBuilder().appendSuper(super.equals(other))
                .append(acroFormPolicy, params.getAcroFormPolicy()).append(blankPageIfOdd, params.isBlankPageIfOdd())
                .append(outlinePolicy, params.getOutlinePolicy()).append(tocPolicy, params.getTableOfContentsPolicy())
                .append(filenameFooter, params.isFilenameFooter())
                .append(normalizePageSizes, params.isNormalizePageSizes())
                .append(catalogPageLabelsPolicy, params.catalogPageLabelsPolicy)
                .append(firstInputCoverTitle, params.firstInputCoverTitle)
                .append(rotations, params.rotations)
                .isEquals();
    }
}
