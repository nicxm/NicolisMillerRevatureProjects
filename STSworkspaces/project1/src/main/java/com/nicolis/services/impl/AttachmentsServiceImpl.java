package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Attachments;
import com.nicolis.repositories.AttachmentsRepo;
import com.nicolis.services.AttachmentsService;

public class AttachmentsServiceImpl implements AttachmentsService {

	public AttachmentsRepo ar;

	public AttachmentsServiceImpl(AttachmentsRepo ar) {
		super();
		this.ar = ar;
	}

	@Override
	public Attachments getAttachments(int attachId) {
		return ar.getAttachments(attachId);
	}

	@Override
	public List<Attachments> getAllAttachments() {
		return ar.getAllAttachments();
	}

	@Override
	public Attachments addAttachments(Attachments a) {
		return ar.addAttachments(a);
	}

	@Override
	public Attachments updateAttachments(Attachments change) {
		return ar.updateAttachments(change);
	}

	@Override
	public Attachments deleteAttachments(int attachId) {
		return ar.deleteAttachments(attachId);
	}

}
