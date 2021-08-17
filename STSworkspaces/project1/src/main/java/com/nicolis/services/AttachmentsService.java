package com.nicolis.services;

import java.util.List;

import com.nicolis.models.Attachments;

public interface AttachmentsService {

	public Attachments getAttachments(int attachId);

	public List<Attachments> getAllAttachments();

	public Attachments addAttachments(Attachments a);

	public Attachments updateAttachments(Attachments change);

	public Attachments deleteAttachments(int attachId);
}
