/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
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
package org.semanticweb.owlapi.io;

import java.io.IOException;

import javax.annotation.Nonnull;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.UnloadableImportException;

/** An {@code OWLParser} parses an ontology document into an OWL API object
 * representation of an ontology.
 * 
 * @author Matthew Horridge, The University Of Manchester, Bio-Health
 *         Informatics Group, Date: 14-Nov-2006 */
public interface OWLParser {
    /** Parses the ontology that has a concrete representation which is pointed
     * to by the specified document IRI. Implementors of this method should load
     * any imported ontologies with the loadImports method on
     * OWLOntologyManager.
     * 
     * @param documentIRI
     *            The document IRI where the ontology should be loaded from
     * @param ontology
     *            The ontology that the concrete representation should be parsed
     *            into. @return An {@code OWLOntologyFormat} which describes the
     *            concrete representation format which was parsed to obtain the
     *            ontology. This will never be {@code null}.
     * @return The format of the ontology
     * @throws OWLParserException
     *             if there was a problem parsing the ontology. This indicates
     *             an error in the syntax with this ontology document that the
     *             parser reads.
     * @throws IOException
     *             if there was an IOException during parsing
     * @throws OWLOntologyChangeException
     *             if there was a problem updating the specified ontology from
     *             information that was parsed.
     * @throws UnloadableImportException
     *             if loading this ontology prompted the loading of an import
     *             and the import could not be loaded. */
    @Nonnull
    OWLOntologyFormat parse(@Nonnull IRI documentIRI, @Nonnull OWLOntology ontology)
            throws OWLParserException, IOException, OWLOntologyChangeException,
            UnloadableImportException;

    /** Parses the ontology that has a concrete representation which is pointed
     * to by the specified input source. Implementors of this method should load
     * any imported ontologies with the makeImportsLoadRequest method on
     * OWLOntologyManager.
     * 
     * @param documentSource
     *            The input source which points the concrete representation. If
     *            the input source can provide a {@code Reader} then the
     *            ontology is parsed from the {@code Reader}. If the input
     *            source cannot provide a reader then it is parsed from the
     *            {@code InputStream}. If the input source cannot provide an
     *            {@code InputStream} then it is parsed from the ontology
     *            document IRI.
     * @param ontology
     *            The ontology which the representation will be parsed into
     * @return An {@code OWLOntologyFormat} which describes the concrete
     *         representation format which was parsed to obtain the ontology.
     * @throws OWLParserException
     *             if there was a problem parsing the ontology. This indicates
     *             an error in the syntax with this ontology document that the
     *             parser reads.
     * @throws IOException
     *             if there was an IOException during parsing
     * @throws OWLOntologyChangeException
     *             if there was a problem updating the specified ontology from
     *             information that was parsed.
     * @throws UnloadableImportException
     *             if loading this ontology prompted the loading of an import
     *             and the import could not be loaded. */
    @Nonnull
    OWLOntologyFormat parse(@Nonnull OWLOntologyDocumentSource documentSource,
            @Nonnull OWLOntology ontology) throws OWLParserException, IOException,
            OWLOntologyChangeException, UnloadableImportException;

    /** Parses the ontology that has a concrete representation which is pointed
     * to by the specified input source. Implementors of this method should load
     * any imported ontologies with the makeImportsLoadRequest method on
     * OWLOntologyManager.
     * 
     * @param documentSource
     *            The input source which points the concrete representation. If
     *            the input source can provider a {@code Reader} then the
     *            ontology is parsed from the {@code Reader}. If the input
     *            source cannot provide a reader then it is parsed from the
     *            {@code InputStream}. If the input source cannot provide an
     *            {@code InputStream} then it is parsed from the ontology
     *            document IRI.
     * @param ontology
     *            The ontology which the representation will be parsed into
     * @param configuration
     *            A configuration object that provides various generic options
     *            to the parser.
     * @return An {@code OWLOntologyFormat} which describes the concrete
     *         representation format which was parsed to obtain the ontology.
     * @throws OWLParserException
     *             if there was a problem parsing the ontology. This indicates
     *             an error in the syntax with this ontology document that the
     *             parser reads.
     * @throws IOException
     *             if there was an IOException during parsing
     * @throws OWLOntologyChangeException
     *             if there was a problem updating the specified ontology from
     *             information that was parsed.
     * @throws UnloadableImportException
     *             if loading this ontology prompted the loading of an import
     *             and the import could not be loaded. */
    @Nonnull
    OWLOntologyFormat parse(@Nonnull OWLOntologyDocumentSource documentSource,
            @Nonnull OWLOntology ontology,
            @Nonnull OWLOntologyLoaderConfiguration configuration)
            throws OWLParserException, IOException, OWLOntologyChangeException,
            UnloadableImportException;

    /** @return a name for the parser, typically the simple class name */
    String getName();
}
