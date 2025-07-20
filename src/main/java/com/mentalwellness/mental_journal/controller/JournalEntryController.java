package com.mentalwellness.mental_journal.controller;

import com.mentalwellness.mental_journal.model.JournalEntry;
import com.mentalwellness.mental_journal.repository.JournalEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryRepository journalEntryRepo;

    // Create a new journal entry
    @PostMapping("/add")
    public ResponseEntity<JournalEntry> addEntry(@RequestParam Long userId,
                                                 @RequestParam String mood,
                                                 @RequestParam String activities,
                                                 @RequestParam String note) {

        JournalEntry entry = new JournalEntry();
        entry.setUserId(userId);
        entry.setMood(mood);
        entry.setActivities(activities);
        entry.setNote(note);
        entry.setTimestamp(LocalDateTime.now());

        JournalEntry saved = journalEntryRepo.save(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all journal entries for a user
    @GetMapping("/all/{userId}")
    public ResponseEntity<List<JournalEntry>> getEntries(@PathVariable Long userId) {
        List<JournalEntry> entries = journalEntryRepo.findByUserId(userId);
        return ResponseEntity.ok(entries);
    }
}
