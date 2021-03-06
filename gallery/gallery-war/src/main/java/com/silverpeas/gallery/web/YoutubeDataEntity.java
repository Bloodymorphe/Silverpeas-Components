/*
 * Copyright (C) 2000 - 2014 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception. You should have recieved a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.org/docs/core/legal/floss_exception.html"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.silverpeas.gallery.web;

import com.silverpeas.gallery.constant.StreamingProvider;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;

/**
 * @author Yohann Chastagnier
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class YoutubeDataEntity extends StreamingProviderDataEntity {
  private static final long serialVersionUID = 6909168681705256783L;

  /**
   * Default hidden constructor.
   */
  YoutubeDataEntity(final JSONObject oembedYoutubeData) {
    super(StreamingProvider.youtube, oembedYoutubeData);
    if (getThumbnailUrl() != null) {
      String thumbnailUrlPrefix = getThumbnailUrl().toString().replaceAll("[^/]+$", "");
      for (int i = 1; i <= 3; i++) {
        getThumbnailPreviewUrls().add(URI.create(thumbnailUrlPrefix + i + ".jpg"));
      }
    }
  }

  @SuppressWarnings("UnusedDeclaration")
  protected YoutubeDataEntity() {
    super();
  }
}
