/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.tools.doclets.internal.toolkit.builders;

import java.io.*;

import com.sun.javadoc.*;
import com.sun.tools.doclets.internal.toolkit.*;

/**
 * Builds the summary for a given annotation type.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 * @since 1.5
 */
@Deprecated
public class AnnotationTypeBuilder extends AbstractBuilder {

    /**
     * The root element of the annotation type XML is {@value}.
     */
    public static final String ROOT = "AnnotationTypeDoc";

    /**
     * The annotation type being documented.
     */
    private final AnnotationTypeDoc annotationTypeDoc;

    /**
     * The doclet specific writer.
     */
    private final AnnotationTypeWriter writer;

    /**
     * The content tree for the annotation documentation.
     */
    private Content contentTree;

    /**
     * Construct a new ClassBuilder.
     *
     * @param context           the build context.
     * @param annotationTypeDoc the class being documented.
     * @param writer            the doclet specific writer.
     */
    private AnnotationTypeBuilder(Context context,
            AnnotationTypeDoc annotationTypeDoc,
            AnnotationTypeWriter writer) {
        super(context);
        this.annotationTypeDoc = annotationTypeDoc;
        this.writer = writer;
    }

    /**
     * Construct a new ClassBuilder.
     *
     * @param context           the build context.
     * @param annotationTypeDoc the class being documented.
     * @param writer            the doclet specific writer.
     */
    public static AnnotationTypeBuilder getInstance(Context context,
            AnnotationTypeDoc annotationTypeDoc,
            AnnotationTypeWriter writer)
            throws Exception {
        return new AnnotationTypeBuilder(context, annotationTypeDoc, writer);
    }

    /**
     * {@inheritDoc}
     */
    public void build() throws IOException {
        build(layoutParser.parseXML(ROOT), contentTree);
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return ROOT;
    }

    /**
      * Build the annotation type documentation.
      *
      * @param node the XML element that specifies which components to document
      * @param contentTree the content tree to which the documentation will be added
      */
     public void buildAnnotationTypeDoc(XMLNode node, Content contentTree) throws Exception {
         contentTree = writer.getHeader(configuration.getText("doclet.AnnotationType") +
                " " + annotationTypeDoc.name());
         Content annotationContentTree = writer.getAnnotationContentHeader();
         buildChildren(node, annotationContentTree);
         writer.addAnnotationContentTree(contentTree, annotationContentTree);
         writer.addFooter(contentTree);
         writer.printDocument(contentTree);
         writer.close();
         copyDocFiles();
     }

     /**
      * Copy the doc files for the current ClassDoc if necessary.
      */
     private void copyDocFiles() {
        PackageDoc containingPackage = annotationTypeDoc.containingPackage();
        if((configuration.packages == null ||
            !configuration.packages.contains(containingPackage) &&
            !containingPackagesSeen.contains(containingPackage))){
            //Only copy doc files dir if the containing package is not
            //documented AND if we have not documented a class from the same
            //package already. Otherwise, we are making duplicate copies.
            utils.copyDocFiles(configuration, containingPackage);
            containingPackagesSeen.add(containingPackage);
        }
     }

    /**
     * Build the annotation information tree documentation.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationContentTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeInfo(XMLNode node, Content annotationContentTree) {
        Content annotationInfoTree = writer.getAnnotationInfoTreeHeader();
        buildChildren(node, annotationInfoTree);
        annotationContentTree.addContent(writer.getAnnotationInfo(annotationInfoTree));
    }

    /**
     * If this annotation is deprecated, build the appropriate information.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationInfoTree the content tree to which the documentation will be added
     */
    public void buildDeprecationInfo (XMLNode node, Content annotationInfoTree) {
        writer.addAnnotationTypeDeprecationInfo(annotationInfoTree);
    }

    /**
     * Build the signature of the current annotation type.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationInfoTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeSignature(XMLNode node, Content annotationInfoTree) {
        StringBuilder modifiers = new StringBuilder(
                annotationTypeDoc.modifiers() + " ");
        writer.addAnnotationTypeSignature(utils.replaceText(
                modifiers.toString(), "interface", "@interface"), annotationInfoTree);
    }

    /**
     * Build the annotation type description.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationInfoTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeDescription(XMLNode node, Content annotationInfoTree) {
        writer.addAnnotationTypeDescription(annotationInfoTree);
    }

    /**
     * Build the tag information for the current annotation type.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationInfoTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeTagInfo(XMLNode node, Content annotationInfoTree) {
        writer.addAnnotationTypeTagInfo(annotationInfoTree);
    }

    /**
     * Build the member summary contents of the page.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationContentTree the content tree to which the documentation will be added
     */
    public void buildMemberSummary(XMLNode node, Content annotationContentTree)
            throws Exception {
        Content memberSummaryTree = writer.getMemberTreeHeader();
        configuration.getBuilderFactory().
                getMemberSummaryBuilder(writer).buildChildren(node, memberSummaryTree);
        annotationContentTree.addContent(writer.getMemberSummaryTree(memberSummaryTree));
    }

    /**
     * Build the member details contents of the page.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationContentTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeMemberDetails(XMLNode node, Content annotationContentTree) {
        Content memberDetailsTree = writer.getMemberTreeHeader();
        buildChildren(node, memberDetailsTree);
        if (memberDetailsTree.isValid()) {
            annotationContentTree.addContent(writer.getMemberDetailsTree(memberDetailsTree));
        }
    }

    /**
     * Build the annotation type field documentation.
     *
     * @param node the XML element that specifies which components to document
     * @param memberDetailsTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeFieldDetails(XMLNode node, Content memberDetailsTree)
            throws Exception {
        configuration.getBuilderFactory().
                getAnnotationTypeFieldsBuilder(writer).buildChildren(node, memberDetailsTree);
    }

    /**
     * Build the annotation type optional member documentation.
     *
     * @param node the XML element that specifies which components to document
     * @param memberDetailsTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeOptionalMemberDetails(XMLNode node, Content memberDetailsTree)
            throws Exception {
        configuration.getBuilderFactory().
                getAnnotationTypeOptionalMemberBuilder(writer).buildChildren(node, memberDetailsTree);
    }

    /**
     * Build the annotation type required member documentation.
     *
     * @param node the XML element that specifies which components to document
     * @param memberDetailsTree the content tree to which the documentation will be added
     */
    public void buildAnnotationTypeRequiredMemberDetails(XMLNode node, Content memberDetailsTree)
            throws Exception {
        configuration.getBuilderFactory().
                getAnnotationTypeRequiredMemberBuilder(writer).buildChildren(node, memberDetailsTree);
    }
}
