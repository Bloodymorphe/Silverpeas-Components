/**
 * Copyright (C) 2000 - 2013 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have recieved a copy of the text describing
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
package com.silverpeas.gallery.model;


import com.silverpeas.gallery.model.MediaCriteria.VISIBILITY;
import com.stratelia.webactiv.util.node.model.NodeDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.silverpeas.gallery.control.ejb.MediaServiceFactory.getMediaService;

public class AlbumDetail extends NodeDetail {

  private static final long serialVersionUID = 1L;
  private VISIBILITY mediaVisibility = VISIBILITY.BY_DEFAULT;
  private List<Media> media = null;
  private long nbMedia = 0;

  public AlbumDetail(NodeDetail node) {
    setNodePK(node.getNodePK());
    setName(node.getName());
    setDescription(node.getDescription());
    setCreationDate(node.getCreationDate());
    setCreatorId(node.getCreatorId());
    setPath(node.getPath());
    setLevel(node.getLevel());
    setStatus(node.getStatus());
    setFatherPK(node.getFatherPK());
    setChildrenDetails(node.getChildrenDetails());
    setType(node.getType());
    setOrder(node.getOrder());
    setTranslations(node.getTranslations());
  }

  public AlbumDetail(NodeDetail node, VISIBILITY mediaVisibility) {
    this(node);
    this.mediaVisibility = mediaVisibility;
  }

  public List<Media> getMedia() {
    if (media == null) {
      // Loading lazily the media data
      final Collection<Media> media = getMediaService().getAllMedia(getNodePK(), mediaVisibility);
      // Setting the media into the instance.
      setMedia(media);
    }
    return media;
  }

  public void setMedia(Collection<Media> media) {
    this.media = new ArrayList<Media>(media);
    if (nbMedia == 0 && media.size() > 0) {
      setNbMedia(nbMedia);
    }
  }

  public long getNbMedia() {
    return nbMedia;
  }

  public void setNbMedia(long nbMedia) {
    this.nbMedia = nbMedia;
  }

  public Collection<AlbumDetail> getChildrenAlbumsDetails() {
    Collection<AlbumDetail> albums = new ArrayList<AlbumDetail>();
    Collection<NodeDetail> nodes = this.getChildrenDetails();
    if (nodes != null) {
      for (NodeDetail node : nodes) {
        AlbumDetail album = new AlbumDetail(node);
        albums.add(album);
      }
    }
   return albums;
  }

}
