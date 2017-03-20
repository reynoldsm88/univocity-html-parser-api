/*
 * Copyright (c) 2013 uniVocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 */

package com.univocity.api.entity.html.builders;

/**
 * A path to a field of an entity. Created every time a field is added to
 * {@link com.univocity.api.entity.html.HtmlEntitySettings}
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 */
public interface FieldPath extends ElementFilter<FieldPath>, ContentReader<FieldContentTransform>, PathStart {


}
