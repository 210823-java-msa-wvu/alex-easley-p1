package dev.easley.services;

import dev.easley.models.Approvals;
import dev.easley.models.Requests;
import dev.easley.repos.ApprovalRepo;

import java.util.List;

public class ApprovalService {

    ApprovalRepo approvalRepo = new ApprovalRepo();

    public Boolean bcUpdate(Approvals approvals) {
        approvalRepo.BCupdate(approvals);
        return true;
    }

    public Boolean dhUpdate(Approvals approvals) {
        approvalRepo.DHupdate(approvals);
        return true;
    }

    public Boolean dsUpdate(Approvals approvals) {
        approvalRepo.update(approvals);
        return true;
    }
    public List<Approvals> allApprovals() {

        return approvalRepo.getAll();

    }
    public List<Approvals> allApprovalsById(Integer id) {
        return approvalRepo.getAllById(id);
    }
}
