package com.mailbox.email.inbox.controllers;

import com.mailbox.email.inbox.folders.Folder;
import com.mailbox.email.inbox.folders.FolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InboxPageController {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private EmailsListRepository emailsListRepository;
    @Autowired
    private FoldersService foldersService;

    private PrettyTime prettyTime = new PrettyTime();

    @GetMapping(value = "/")
    public String getHomePage(@RequestParam(required = false) String folder,
            @AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null && principal.getAttribute("login") != null) {
            String loginId = principal.getAttribute("login");
            List<Folder> folders = folderRepository.findAllById(loginId);
            List<Folder> initFolders = foldersService.init(loginId);
            // initFolders.stream().forEach(folderRepository::save);
            model.addAttribute("defaultFolders", initFolders);
            if (folders.size() > 0) {
                model.addAttribute("userFolders", folders);
            }
            if (StringUtils.isBlank(folder)) {
                folder = "Inbox";
            }
            model.addAttribute("currentFolder", folder);
            Map<String, Integer> folderToUnreadCounts = foldersService.getUnreadCountsMap(loginId);
            model.addAttribute("folderToUnreadCounts", folderToUnreadCounts);
            List<EmailsList> emails = emailsListRepository.findAllById_UserIdAndId_Label(loginId, folder);
            emails.stream().forEach(email -> {
                Date emailDate = new Date(Uuids.unixTimestamp(email.getId().getTimeId()));
                email.setAgoTimeString(prettyTime.format(emailDate));
            });
            model.addAttribute("folderEmails", emails);

            return "inbox-page";
        }
        return "index";

    }

    

}
