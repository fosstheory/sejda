/*
 * Created on 23/jul/2011
 *
 * Copyright 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
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
package org.sejda.core.manipulation.model.task.itext.component.input;

import org.sejda.core.manipulation.model.input.PdfSourceOpener;

import com.lowagie.text.pdf.PdfReader;

/**
 * This class contains only static factory methods to create {@link PdfSourceOpener} implementations.
 * 
 * @author Andrea Vacondio
 * 
 */
public final class PdfSourceOpeners {

    private PdfSourceOpeners() {
        // hide
    }

    /**
     * Factory method returning a {@link PdfSourceOpener} that performs a full read on the opened source.
     * 
     * @return the newly created {@link PdfSourceOpener}
     */
    public static PdfSourceOpener<PdfReader> newFullReadOpener() {
        return new FullReadPdfSourceOpener();
    }

    /**
     * Factory method returning a {@link PdfSourceOpener} that performs a partial read on the opened source.
     * 
     * @return the newly created {@link PdfSourceOpener}
     */
    public static PdfSourceOpener<PdfReader> newPartialReadOpener() {
        return new PartialReadPdfSourceOpener();
    }

}
