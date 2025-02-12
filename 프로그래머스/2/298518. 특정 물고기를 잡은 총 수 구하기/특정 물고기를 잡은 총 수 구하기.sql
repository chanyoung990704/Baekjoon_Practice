select count(id) as FISH_COUNT 
from fish_info i
join fish_name_info n on i.fish_type = n.fish_type
where FISH_NAME in ('BASS', 'SNAPPER')
