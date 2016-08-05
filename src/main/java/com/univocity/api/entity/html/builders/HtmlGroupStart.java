/*
 * Copyright (c) 2013 uniVocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 */

package com.univocity.api.entity.html.builders;

/**
 * This class defines the first step in the creation of a {@link HtmlGroup}. {@link HtmlGroup}s allow the definition
 * of 'parsing areas', where fields created from this group will only return values matched from inside the group. For the
 * fields in the group, HTML elements outside of the group will be ignored by the parser, even if the fields match
 * elements in this outside area.
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 * @see HtmlGroup
 * @see PartialHtmlGroup
 */
public interface HtmlGroupStart {

	/**
	 * Specifies where on the HTML that the group will start. Any HTML before this starting element will be ignored by
	 * the parser when parsing fields creating from this group. Returns a {@link PartialHtmlGroup} which allows the further
	 * specification of exactly what element on the page the group will start at. {@link PartialHtmlGroup} also provides
	 * methods to define what element the group will end at.
	 *
	 * @param elementName the name of the HTML element that the group will start at
	 * @return a {@link PartialHtmlGroup} which is used to further specify the exact element where the group will start
	 * and where the group will end.
	 */
	PartialHtmlGroup startAt(String elementName);
}
