import csv
from pathlib import Path
p = Path('target/site/jacoco/jacoco.csv')
if not p.exists():
    print('ERROR: jacoco.csv not found at', p)
    raise SystemExit(1)

rows = []
with p.open(encoding='utf-8') as f:
    reader = csv.DictReader(f)
    for r in reader:
        try:
            missed = int(r['LINE_MISSED'])
            covered = int(r['LINE_COVERED'])
        except Exception:
            continue
        total = missed + covered
        pct = (covered / total * 100) if total>0 else 100.0
        rows.append((pct, r['PACKAGE'], r['CLASS'], missed, covered))

rows.sort(key=lambda x: x[0])
print('Top low-coverage classes (by line coverage %):')
for pct, pkg, cls, missed, covered in rows[:15]:
    print(f"{pct:.1f}% - {pkg}.{cls} (lines missed={missed}, covered={covered})")
print('\nTotal classes parsed:', len(rows))
