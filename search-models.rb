#!/usr/bin/ruby

puts "Start fetching android models"

if __FILE__ == $0
	puts "All sets right."
	answers = []
	ARGV.each do |a|
		puts "Matching #{a}"
    
		file = File.open('Build.Model - models.csv').read
		file.gsub!(/\r\n?/, "\n")
		file.each_line do |line|
			spl = line.split(',')
			if (spl.any?{ |s| s.downcase.include?((a.downcase)) }) 
				answers << "#{spl[0]} - #{spl[1]} - #{spl[3]}"
			end
		end
    end
	puts answers
end
