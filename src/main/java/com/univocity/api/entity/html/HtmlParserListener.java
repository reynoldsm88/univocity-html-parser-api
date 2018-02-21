/*
 * Copyright (c) 2013 uniVocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 */

package com.univocity.api.entity.html;

/**
 * An abstract class that is used by the {@link HtmlParser} to provide information about events that occur during
 * the parsing process.
 *
 * <b>Important:</b>This listener is used in a concurrent environment. If you are assigning the same
 * instance to multiple entities make sure your implementation is thread-safe, or limit the number
 * of threads to be used when parsing to <b>1</b> with {@link HtmlParserSettings#setParserThreadCount(int)}
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 * @see HtmlParser
 * @see HtmlParsingContext
 * @see HtmlElement
 */
public abstract class HtmlParserListener {

	/**
	 * A method that runs when the {@link HtmlParser} begins parsing.
	 *
	 * @param context the {@link HtmlParsingContext} used by the {@link HtmlParser} during the parsing process
	 */
	public void parsingStarted(HtmlParsingContext context) {
	}

	/**
	 * A method that runs every time the {@link HtmlParser} visits a HTML element on a HTML document.
	 *
	 * @param element the element that was visited. Note that only elements with tags are visited. Text nodes will
	 *                not trigger the invocation of this method.
	 * @param context the {@link HtmlParsingContext} used by the {@link HtmlParser} during the parsing process
	 */
	public void elementVisited(HtmlElement element, HtmlParsingContext context) {
	}

	/**
	 * A method that runs when a HTML element is matched based on the path set in the creation a field in the
	 * corresponding {@link HtmlEntitySettings}
	 *
	 * @param element the element that was matched
	 * @param context the {@link HtmlParsingContext} used by the {@link HtmlParser} during the parsing process
	 */
	public void elementMatched(HtmlElement element, HtmlParsingContext context) {
	}

	/**
	 * A method that runs when the parsing process has ended.
	 *
	 * @param context the {@link HtmlParsingContext} used by the {@link HtmlParser} during the parsing process
	 */
	public void parsingEnded(HtmlParsingContext context) {
	}
}
