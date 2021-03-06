/*
 * Copyright (c) 2013 Univocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 */

package com.univocity.api.entity.html.builders;

import com.univocity.api.common.*;
import com.univocity.api.entity.html.*;
import com.univocity.api.entity.html.builders.annotations.*;
import com.univocity.api.net.*;

import java.io.*;

/**
 * Allows the content captured for a given field, by a {@link ContentReader}, to be transformed by a
 * {@link StringTransformation} to clean up or transform values or to obtain very specific textual content from the
 * original value.
 *
 * Also provides operations for linking to/downloading content from absolute or relative URLs extracted into values of
 * a field.
 *
 * @author Univocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 */
public interface FieldContentTransform extends ContentHandler<FieldContentTransform> {

	/**
	 * Specifies that the parser will download content from the URL in the HTML element defined by the
	 * path. This is useful for downloading binary files such as images and videos linked with 'src' or 'href' attributes.
	 *
	 * Content will be downloaded to the directory specified by
	 * {@link HtmlParserSettings#setDownloadContentDirectory(File)}. If the download directory is not set, the content
	 * will be stored in a temporary directory.
	 */
	@Matcher(type = Matcher.Type.ATTRIBUTE)
	void download();

	/**
	 * Specifies that the parser will download content from the URL in the HTML element defined by the
	 * path. This is useful for downloading binary files such as images and videos linked by 'src' or 'href' attributes.
	 *
	 * Content will be downloaded to the directory specified by
	 * {@link HtmlParserSettings#setDownloadContentDirectory(File)}. If the download directory is not set, the content
	 * will be stored in a temporary directory.
	 *
	 * @param baseUrlProvider the base URL and associated configuration to be used for downloading the content.
	 *                        Required for downloading content wile parsing data from local files.
	 */
	@Matcher(type = Matcher.Type.ATTRIBUTE)
	void download(UrlReaderProvider baseUrlProvider);

	/**
	 * Creates a {@link HtmlLinkFollower} that will parse linked pages, each linked page URL is defined by the values
	 * retrieved by this field. Each URL returned by this field will be parsed by the associated {@link HtmlLinkFollower}.
	 * A {@link HtmlLinkFollower} is essentially a special type of {@link HtmlEntityList} that allows fields and entities
	 * to be added to it.
	 *
	 * For each parsed row, the {@link HtmlParser} will combine it with the results from all associated
	 * link followers, using the nesting strategy defined by {@link HtmlLinkFollower#getNesting()}.
	 *
	 *
	 * If a value parsed in this field is not a valid URL, the parsing process will stop unless
	 * {@link HtmlLinkFollower#ignoreFollowingErrors(boolean)} has been set to `true`.
	 *
	 * @return the created {@link HtmlLinkFollower} which allows the addition of fields and entities to define what data
	 * from the linked page should be returned.
	 */
	HtmlLinkFollower followLink();

	/**
	 * Creates a {@link HtmlLinkFollower} that will parse linked pages, each linked page URL is defined by inserting
	 * the value retrieved by this field into the supplied {@link UrlReaderProvider} as a parameter.
	 *
	 * For example, if the current entity has a field named "query", which retrieves the values 'cat' and 'dog', and
	 * the {@link UrlReaderProvider} provided here has the parameterized URL "https://www.google.com/search?q={query}",
	 * two pages will be parsed as the values replace the `{query}` parameter in the URL:
	 *
	 *  * `https://www.google.com/search?q=cat` and
	 *  * `https://www.google.com/search?q=dog`
	 *
	 * A {@link HtmlLinkFollower} is essentially a special type of {@link HtmlEntityList} that allows additional fields
	 * to be added to the current parent entity. It also allows more entities to be added to it. For each parsed row
	 * of the parent page, the {@link HtmlParser} will combine their results with the rows of all associated
	 * link followers, using the nesting strategy defined by {@link HtmlLinkFollower#getNesting()}.
	 *
	 * If a value parsed in this field is not a valid URL, the parsing process will stop unless
	 * {@link HtmlLinkFollower#ignoreFollowingErrors(boolean)} has been set to `true`.
	 *
	 * @param urlReaderProvider the parameterized URL that values parsed from this field will be inserted into to get
	 *                          a linked page
	 *
	 * @return the created {@link HtmlLinkFollower} which allows the addition of fields and entities to define what data
	 * from the linked page will be returned.
	 */
	HtmlLinkFollower followLink(UrlReaderProvider urlReaderProvider);

}
