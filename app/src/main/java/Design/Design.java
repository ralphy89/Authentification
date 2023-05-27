package Design;

import static androidx.core.content.res.ResourcesCompat.getColor;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import com.uniq_lab1.authentification.R;

public class Design {


    public Design(){}
    public static void changeTextColor(TextView textView, int firstLetterColorRes, int lastTwoLettersColorRes) {
        String text = textView.getText().toString();

        SpannableString spannableString = new SpannableString(text);

        // Set color for the first letter
        ForegroundColorSpan firstLetterColorSpan = new ForegroundColorSpan(ContextCompat.getColor(textView.getContext(), firstLetterColorRes));
        spannableString.setSpan(firstLetterColorSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set color for the last two letters
        int textLength = text.length();
        if (textLength >= 3) {
            ForegroundColorSpan lastTwoLettersColorSpan = new ForegroundColorSpan(ContextCompat.getColor(textView.getContext(), lastTwoLettersColorRes));
            spannableString.setSpan(lastTwoLettersColorSpan, textLength - 2, textLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        textView.setText(spannableString);
    }
}
