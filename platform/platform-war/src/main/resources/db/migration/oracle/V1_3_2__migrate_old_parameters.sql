
declare
	cursor journal_entries is
		select *
			from journal
			where param1 is not null;
			
	journal_entry journal%rowtype;
begin
	open journal_entries;
	
	loop
		fetch journal_entries into journal_entry;
		exit when journal_entries%NOTFOUND;
		
		insert into journal_parameter(parameter_id, param_no, param_value)
			values(journal_entry.id, 1, journal_entry.param1);
	end loop;
	
	close journal_entries;
end;
