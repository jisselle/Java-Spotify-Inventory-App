package edu.cscc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cscc.model.Record;
import edu.cscc.repository.RecordRepository;

@Controller
public class RecordController {
	@Autowired
	private RecordRepository repository;
	
		@GetMapping("/add-record")
		public String getRecordForm(Model model) {		
			model.addAttribute("recordRequest", new Record());
			return "add-record";
		}
		
		@PostMapping("/records")
		public String postRecord(@Valid @ModelAttribute("recordRequest") Record record, BindingResult bindingResult)
		{		
			if (bindingResult.hasErrors()) {
				return "add-record";
			}
			
			var createdRecord = repository.save(record);
			return "redirect:/records/" + createdRecord.id;
		}
		
		@GetMapping("/records")
		public String getRecords(Model model) {
			var records = repository.findAll();
			model.addAttribute("records", records);

			return "records";
		}
		
		@GetMapping("/records/{id}")
		public String getRecord(@PathVariable long id, Model model) {
			var record = repository.findById(id).get();
			
			model.addAttribute("title", record.title);
			model.addAttribute("artist", record.artist);
			model.addAttribute("label", record.label);
			model.addAttribute("releaseYear", record.releaseYear);
			model.addAttribute("trackAmount", record.trackAmount);
			model.addAttribute("recordSize", record.recordSize);
			model.addAttribute("isDamaged", record.isDamaged);
			
			return "record";
		}
		
		@GetMapping("/records/edit/{id}")
		public String getEditRecordForm(@PathVariable long id, Model model) {
		    var record = repository.findById(id).orElse(null);

		    if (record != null) {
		        model.addAttribute("recordRequest", record);
		        return "edit-record";
		    } else {
		        return "redirect:/records";
		    }
		}

		    @PostMapping("/records/edit/{id}")
		    public String postEditRecordForm(@PathVariable long id, @Valid @ModelAttribute("recordRequest") Record updatedRecord, BindingResult bindingResult) {
		        if (bindingResult.hasErrors()) {
		            return "edit-record";
		        }

		        var record = repository.findById(id).orElse(null);

		        if (record != null) {
		        	record.setTitle(updatedRecord.getTitle());
		        	record.setArtist(updatedRecord.getArtist());
		        	record.setLabel(updatedRecord.getLabel());
		        	record.setReleaseYear(updatedRecord.getReleaseYear());
		        	record.setTrackAmount(updatedRecord.getTrackAmount());
		        	record.setRecordSize(updatedRecord.getRecordSize());
		        	record.setDamaged(updatedRecord.isDamaged());

		            repository.save(record);
		            return "redirect:/records/" + record.getId();
		        } else {
		            return "redirect:/records";
		        }
		    }
		}