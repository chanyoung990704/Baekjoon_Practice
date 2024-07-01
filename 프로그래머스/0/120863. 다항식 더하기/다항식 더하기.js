function solution(polynomial) {
    var terms = polynomial.split('+').map(term => term.trim());
    
    let xCoefficient = 0;
    let constant = 0;
    
    terms.forEach(term => {
        if (term.includes('x')) {
            if (term === 'x') {
                xCoefficient += 1;
            } else {
                xCoefficient += parseInt(term);
            }
        } else {
            constant += parseInt(term);
        }
    });
    
    let result = [];
    
    if (xCoefficient !== 0) {
        if (xCoefficient === 1) {
            result.push('x');
        } else {
            result.push(xCoefficient + 'x');
        }
    }
    
    if (constant !== 0) {
        result.push(constant.toString());
    }
    
    return result.join(" + ");
}