#include <string>
#include <cctype>

using namespace std;

string solution(string s) {
    bool capitalizeNext = true; // Flag to indicate whether the next character should be capitalized
    for (char& c : s) {
        if (isspace(c)) {
            capitalizeNext = true; // Reset flag for the next word
        } else {
            if (capitalizeNext) {
                c = toupper(c); // Capitalize the first character of the word
                capitalizeNext = false; // Set the flag to false for subsequent characters
            } else {
                c = tolower(c); // Convert subsequent characters to lowercase
            }
        }
    }
    return s;
}
