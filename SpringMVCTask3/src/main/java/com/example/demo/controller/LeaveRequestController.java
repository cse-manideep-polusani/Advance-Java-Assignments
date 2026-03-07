package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.LeaveTypeRepository;

@Controller
@RequestMapping("/leave")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;   // ✅ ADD THIS


    @GetMapping("/apply")
    public String showLeaveForm(Model model) {

        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("leaveTypes", leaveTypeRepository.findAll());  // ✅ IMPORTANT

        return "leave-form";
    }

    @PostMapping("/save")
    public String saveLeave(@ModelAttribute LeaveRequest leaveRequest) {

        leaveRequest.setStatus("PENDING");
        leaveRequestRepository.save(leaveRequest);

        return "redirect:/leave/list";
    }

    @GetMapping("/list")
    public String listLeaves(Model model) {

        model.addAttribute("leaveList", leaveRequestRepository.findAll());

        return "leave-list";
    }
}